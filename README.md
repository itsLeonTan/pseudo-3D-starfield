# Pseudo-3D-Starfield
A Java starfield simulator built using Java Swing (JFrame/JPanel).

## Preview

![Starfield](https://github.com/user-attachments/assets/0ada8833-fe4f-4673-9478-412fc53a8c7e)

## Inspiration

This is a coding practice project inspired by a [Coding Challenge video from Daniel Shiffman on The Coding Train](https://youtu.be/17WoOqgXsRM?si=sfyEwFVVQNk1lntZ). 

While the core concept is similar, the implementation differs and was written independently in Java. 

The goal remains the same: simulating 3D high-speed space travel in a 2D environment.

## How It Works

Each `Star` object holds an `x`, `y`, and `z` value representing its position in 3D space relative to the screen center. 

Movement is calculated through this formula:

$$x_{proj} = \frac{x - (\frac{WIDTH}{2})}{z}$$

$$y_{proj} = \frac{y - (\frac{HEIGHT}{2})}{z}$$

Dividing by `z` simulates perspective projection. Stars with smaller `z`-values appear closer to the viewer and therefore moving faster away from the center of the screen.

In each frame, `z` is subtracted by the speed:

$$z_{n+1} = z_n - v$$

The size of the size is also determined by `z`. The higher the `z`-value, the smaller the star, and vice versa. 

As `z` decreases, the projected position expands outward and the star grows in size, creating the illusion of forward motion and depth.

When a star moves beyond the screen bounds, it is replaced with a new star at a randomized position to maintain a continuous starfield effect.

## What I Learned

* How to create depth from 3D coordinates in a 2D space
* How the repaint cycle works in Swing
* Managing large numbers of animated objects efficiently
