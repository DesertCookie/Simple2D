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
import desertcookie.simple2d.rendering.SimpleGraphics;
import desertcookie.simple2d.textures.Texture;


/**
 * Repräsentation eines allgemeinen Spielobjekts mit Eigenschaften wie Position und Größe.
 *
 * @since 0.3.4
 */
public abstract class Entity {
	
	
	/**
	 * Position in Pixeln.
	 *
	 * @since 0.3.4
	 */
	protected double x, y;
	/**
	 * Größe in Pixeln.
	 *
	 * @since 0.3.4
	 */
	protected double w, h;
	/**
	 * Textur dieses Entities.
	 *
	 * @since 0.3.4
	 */
	protected Texture texture;
	
	
	/**
	 * Konstruiert neuen Entity.
	 *
	 * @param x       Horizontale Position in Pixeln
	 * @param y       Vertikale Position in Pixeln
	 * @param w       Horizontale Größe in Pixeln
	 * @param h       Vertikale Größe in Pixeln
	 * @param texture Textur dieses Entity
	 * @since 0.3.4
	 */
	public Entity( double x,double y,double w,double h,Texture texture ) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.texture = texture;
	}
	
	/**
	 * Konstruiert neuen Entity mit der Größe der angegebenen Textur.
	 *
	 * @param x       Horizontale Position in Pixeln
	 * @param y       Vertikale Position in Pixeln
	 * @param texture Textur dieses Entity
	 * @since 0.3.4
	 */
	public Entity( double x,double y,Texture texture ) {
		this.x = x;
		this.y = y;
		this.w = texture.getWidth();
		this.h = texture.getHeight();
		this.texture = texture;
	}
	
	
	/**
	 * Methode für Update-Code.
	 *
	 * @param deltaTime Zeit seit dem letzten Update in Sekunden
	 * @param input     Schnittstelle für Input
	 * @since 0.3.4
	 */
	public abstract void update( double deltaTime,InputHandler input );
	
	/**
	 * Methode für Render-Code.
	 *
	 * @param graphics Schnittstelle für Rendering
	 * @since 0.3.4
	 */
	public abstract void render( SimpleGraphics graphics );
	
	
	/**
	 * @return Horizontale Position dieses Entity in Pixeln.
	 * @since 0.3.4
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Setzt die horizontale Position dieses Entity.
	 *
	 * @param x Horizontale Position in Pixeln
	 * @since 0.3.4
	 */
	public void setX( double x ) {
		this.x = x;
	}
	
	/**
	 * @return Vertikale Position dieses Entity in Pixeln.
	 * @since 0.3.4
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Setzt die vertikale Position dieses Entity.
	 *
	 * @param y Vertikale Position in Pixeln
	 * @since 0.3.4
	 */
	public void setY( double y ) {
		this.y = y;
	}
	
	/**
	 * Setzt die Position dieses Entity.
	 *
	 * @param x Horizontale Position in Pixeln
	 * @param y Vertikale Position in Pixeln
	 */
	public void setLocation( double x,double y ) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Bewegt diesen Entity um die angegebene Distanz.
	 *
	 * @param dx Distanz in der Horizontalen in Pixeln
	 * @param dy Distanz in der Vertikalen in Pixeln
	 * @since 0.3.4
	 */
	public void move( double dx,double dy ) {
		x += dx;
		y += dy;
	}
	
	/**
	 * @return Horizontale Größe dieses Entity in Pixeln.
	 * @since 0.3.4
	 */
	public double getW() {
		return w;
	}
	
	/**
	 * Setzt die horizontale Größe dieses Entity.
	 *
	 * @param w Horizontale Größe in Pixeln
	 * @since 0.3.4
	 */
	public void setW( double w ) {
		this.w = w;
	}
	
	/**
	 * @return Vertikale Größe dieses Entity in Pixeln.
	 * @since 0.3.4
	 */
	public double getH() {
		return h;
	}
	
	/**
	 * Setzt die vertikale Größe dieses Entity.
	 *
	 * @param h Vertikale Größe in Pixeln
	 * @since 0.3.4
	 */
	public void setH( double h ) {
		this.h = h;
	}
	
	/**
	 * Setzt Breite und Höhe dieses Entity.
	 *
	 * @param w Horizontale Größe in Pixeln
	 * @param h Vertikale Größe in Pixeln
	 */
	public void setSize( double w,double h ) {
		this.w = w;
		this.h = h;
	}
	
	/**
	 * Skaliert diesen Entity mit den gegebenen Faktoren.
	 *
	 * @param dxs Faktor für Skalierung in der Horizontalen
	 * @param dys Faktor für Skalierung in der Vertikalen
	 * @since 0.3.4
	 */
	public void resize( double dxs,double dys ) {
		w *= dxs;
		h *= dys;
	}
	
	/**
	 * @return Textur dieses Entity.
	 * @since 0.3.4
	 */
	public Texture getTexture() {
		return texture;
	}
	
	/**
	 * Setzt die Textur dieses Entity.
	 *
	 * @param texture Textur dieses Entity
	 * @since 0.3.4
	 */
	public void setTexture( Texture texture ) {
		this.texture = texture;
	}
	
	/**
	 * @param entity Entity der überprüft werden soll
	 * @return {@code true} wenn dieser Entity mit dem angegebenen Entity kollidiert.
	 * @since 0.3.4
	 */
	public boolean collides( Entity entity ) {
		return isPointInside( entity.x,entity.y ) && isPointInside( entity.x + entity.w,entity.y ) && isPointInside( entity.x + entity.w,entity.y + entity.h ) && isPointInside( entity.x,entity.y + entity.h );
	}
	
	
	/**
	 * @param x Horizontale Position des Punktes in Pixeln
	 * @param y Vertikale Position des Punktes in Pixeln
	 * @return {@code true} wenn der angegebene Punkt mit diesem Entity kollidiert.
	 * @since 0.3.4
	 */
	protected boolean isPointInside( double x,double y ) {
		return x >= this.x && x <= this.x + this.w && y >= this.y && y <= this.y + this.h;
	}
	
	
}
