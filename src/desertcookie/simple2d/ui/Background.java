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

package desertcookie.simple2d.ui;


import desertcookie.simple2d.core.Game;
import desertcookie.simple2d.input.InputHandler;
import desertcookie.simple2d.rendering.SimpleGraphics;
import desertcookie.simple2d.textures.Texture;


/**
 * Ui-Komponente zur Darstellung eines statischen oder bewegten Hintergrunds.
 *
 * @since 0.4.7
 */
public class Background extends UiComponent {
	
	
	private double speedX;
	
	
	/**
	 * Konstruiert neuen statischen Background.
	 *
	 * @param x       Horizontale Position in Pixeln
	 * @param y       Vertikale Position in Pixeln
	 * @param w       Horizontale Größe in Pixeln
	 * @param h       Vertikale Größe in Pixeln
	 * @param texture Textur dieses Backgrounds
	 * @since 0.4.7
	 */
	public Background( double x,double y,double w,double h,Texture texture ) {
		super( x,y,w,h );
		this.texture = texture;
	}
	
	/**
	 * Konstruiert neuen bewegten Background.
	 *
	 * @param x       Horizontale Position in Pixeln
	 * @param y       Vertikale Position in Pixeln
	 * @param w       Horizontale Größe in Pixeln
	 * @param h       Vertikale Größe in Pixeln
	 * @param texture Textur dieses Backgrounds
	 * @param speedX  Horizontale Geschwindigkeit dieses Backgrounds in Pixeln pro Sekunde
	 * @since 0.4.7
	 */
	public Background( double x,double y,double w,double h,Texture texture,double speedX ) {
		super( x,y,w,h );
		this.texture = texture;
		this.speedX = speedX;
	}
	
	
	@Override
	public void update( double deltaTime,InputHandler input ) {
		x += speedX * deltaTime;
	}
	
	@Override
	public void render( SimpleGraphics graphics ) {
		graphics.drawTexture( texture,x,y,w,h );
		if( x + w < Game.getDisplay().getWidth() )
			graphics.drawTexture( texture,x + w,y,w,h );
		else if( x > 0 )
			graphics.drawTexture( texture,x - w,y,w,h );
	}
	
	
	/**
	 * @return Horizontale Geschwindigkeit dieses Backgrounds in Pixeln pro Sekunde.
	 * @since 0.4.7
	 */
	public double getSpeedX() {
		return speedX;
	}
	
	/**
	 * Setzt die Horizontale Geschwindigkeit dieses Backgrounds.
	 *
	 * @param speedX Horizontale Geschwindigkeit in Pixeln pro Sekunde
	 * @since 0.4.7
	 */
	public void setSpeedX( double speedX ) {
		this.speedX = speedX;
	}
	
	
}
