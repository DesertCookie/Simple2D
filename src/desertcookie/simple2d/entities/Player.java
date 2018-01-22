/*
 * Copyright (c) 2018 Ruben Hahn (DesertCookie),
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted
 * provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions
 *    and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of
 *    conditions and the following disclaimer in the documentation and/or other materials provided
 *    with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER
 * IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package desertcookie.simple2d.entities;


import desertcookie.simple2d.input.InputHandler;
import desertcookie.simple2d.input.Keyboard;
import desertcookie.simple2d.rendering.SimpleGraphics;
import desertcookie.simple2d.textures.Texture;


/**
 * Repräsentation eines steuerbaren Spielers.
 *
 * @since 0.3.4
 */
public class Player extends Entity {
	
	
	private int keyUp, keyDown, keyLeft, keyRight;
	private double movementSpeed;
	
	
	/**
	 * Konstruiert einen neuen Spieler mit einer standard Bewegunstastenbelegung von WASD.
	 *
	 * @param x             Horizontale Position in Pixeln
	 * @param y             Vertikale Position in Pixeln
	 * @param w             Horizontale Größe in Pixeln
	 * @param h             Vertikale Größe in Pixeln
	 * @param texture       Textur des Spielers
	 * @param movementSpeed Bewegungsgeschwindigkeit in Pixeln pro Sekunde
	 * @since 0.3.4
	 */
	public Player( double x,double y,double w,double h,Texture texture,double movementSpeed ) {
		super( x,y,w,h,texture );
		this.movementSpeed = movementSpeed;
		keyUp = Keyboard.W;
		keyDown = Keyboard.S;
		keyLeft = Keyboard.A;
		keyRight = Keyboard.D;
	}
	
	/**
	 * Konstruiert einen neuen Spieler mit einer standard Bewegungstastenbelegung von WASD und der Größe der angegebenen Textur.
	 *
	 * @param x             Horizontale Position in Pixeln
	 * @param y             Vertikale Position in Pixeln
	 * @param texture       Textur des Spielers
	 * @param movementSpeed Bewegungsgeschwindigkeit in Pixeln pro Sekunde
	 * @since 0.3.4
	 */
	public Player( double x,double y,Texture texture,double movementSpeed ) {
		super( x,y,texture );
		this.movementSpeed = movementSpeed;
		keyUp = Keyboard.W;
		keyDown = Keyboard.S;
		keyLeft = Keyboard.A;
		keyRight = Keyboard.D;
	}
	
	
	@Override
	public void update( double deltaTime,InputHandler input ) {
		if( input.isKeyDown( keyUp ) )
			y -= movementSpeed * deltaTime;
		if( input.isKeyDown( keyDown ) )
			y += movementSpeed * deltaTime;
		if( input.isKeyDown( keyLeft ) )
			x -= movementSpeed * deltaTime;
		if( input.isKeyDown( keyRight ) )
			x += movementSpeed * deltaTime;
	}
	
	@Override
	public void render( SimpleGraphics graphics ) {
		graphics.drawTexture( texture,x,y,w,h );
	}
	
	
	/**
	 * Setzt die Bewegungstastenbelegung.
	 *
	 * @param keyUp    Taste für hoch
	 * @param keyDown  Taste für herunter
	 * @param keyLeft  Taste für links
	 * @param keyRight Taste für rechts
	 * @since 0.3.4
	 */
	public void setControlKeys( int keyUp,int keyDown,int keyLeft,int keyRight ) {
		this.keyUp = keyUp;
		this.keyDown = keyDown;
		this.keyLeft = keyLeft;
		this.keyRight = keyRight;
	}
	
	
}
