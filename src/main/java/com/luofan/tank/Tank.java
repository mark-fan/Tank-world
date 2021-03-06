package com.luofan.tank;

import java.awt.*;

/**
 * 多个坦克基础抽象类
 *
 * @author luofan
 */
public class Tank {
    private int x;
    private int y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 5;
    private TankFrame tankFrame;

    public Tank(int x, int y, Dir dir, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    /**
     * 默认坦克为静止状态
     */
    private boolean moving = false;

    public void paint(Graphics graphics) {
        Color color = graphics.getColor();
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(x, y, 50, 50);
        graphics.setColor(color);
        move();

    }

    private void move() {
        if (!moving) {
            return;
        }
        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public void fire() {
        tankFrame.bullets.add(new Bullet(this.x, this.y, this.dir,this.tankFrame));
    }
}
