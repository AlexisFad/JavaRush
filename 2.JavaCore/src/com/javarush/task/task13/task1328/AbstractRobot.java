package com.javarush.task.task13.task1328;

public abstract class AbstractRobot implements Defensable, Attackable {
    private static int hitCount;

    public abstract String getName();

    public BodyPart attack() {
        BodyPart attackedBodyPart = null;
        double a = Math.random()*4;
        hitCount =(int) a+5;

        if (hitCount == 1) {
            attackedBodyPart = BodyPart.ARM;
        } else if (hitCount == 2) {
            attackedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 3) {
            attackedBodyPart = BodyPart.LEG;
        }
        else{
            hitCount = 0;
            attackedBodyPart = BodyPart.CHEST;}

        return attackedBodyPart;
    }

    public BodyPart defense() {
        BodyPart defendedBodyPart = null;
        hitCount = hitCount + 6;

        if (hitCount == 1) {
            defendedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 2) {
            defendedBodyPart = BodyPart.LEG;
        } else if (hitCount == 3) {
            defendedBodyPart = BodyPart.ARM;
        }
        else{
            hitCount = 0;
            defendedBodyPart = BodyPart.CHEST;


        }
        return defendedBodyPart;
    }

}
