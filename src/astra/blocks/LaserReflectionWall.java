package astra.blocks;

import arc.math.Rand;
import mindustry.content.Blocks;
import mindustry.entities.bullet.ContinuousLaserBulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.game.Team;
import mindustry.gen.Bullet;
import mindustry.gen.Call;
import mindustry.world.blocks.defense.Wall;

public class LaserReflectionWall extends Wall {
    public float laserDamageMultiplier = 0f;
    public float reflectionAngleRange = 8f;
    protected Rand rand = new Rand();

    public LaserReflectionWall(String name) {
        super(name);
        insulated = true;
        absorbLasers = true;
        schematicPriority = Blocks.plastaniumWall.schematicPriority;
    }

    public class LaserReflectionWallBuild extends WallBuild {
        @Override
        public void damage(Bullet bullet, Team source, float damage) {
            if (bullet.type instanceof LaserBulletType && bullet.team != team) {
                super.damage(bullet, source, damage * laserDamageMultiplier);
            }
            if (bullet.type instanceof ContinuousLaserBulletType && bullet.team != team) {
                super.damage(bullet, source, damage * laserDamageMultiplier);
            } else {
                super.damage(bullet, source, damage);
            }
        }

        @Override
        public boolean collision(Bullet other) {
            if (other.type instanceof LaserBulletType && other.team != team) {
                Call.createBullet(other.type, team, x, y, other.angleTo(other.aimTile) + 180f - reflectionAngleRange + rand.nextFloat() * reflectionAngleRange * 2, other.damage, 1f, 1f);
            } else if (other.type instanceof ContinuousLaserBulletType && other.team != team) {
                // TODO 14.09.2025: Do something with this
                Call.createBullet(other.type, team, x, y, other.angleTo(other.aimTile) + 180f - reflectionAngleRange + rand.nextFloat() * reflectionAngleRange * 2, other.damage, 1f, 0.03f);
            }
            return super.collision(other);
        }
    }
}
