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


import desertcookie.simple2d.entities.Entity;
import desertcookie.simple2d.input.InputHandler;
import desertcookie.simple2d.rendering.SimpleGraphics;

import java.awt.*;


/**
 * Repräsentation einer allgemeinen Ui-Komponente mit Eigenschaften wie Position und Größe, sowie Farbwerte und Schriftart.
 *
 * @since 0.4.7
 */
public abstract class UiComponent extends Entity {
	
	
	/**
	 * Farbe von Objekten im Fordergrund.
	 */
	protected Color foreground;
	/**
	 * Farbe von Objekten im Hintergrund.
	 */
	protected Color background;
	/**
	 * Schriftart für Text.
	 */
	protected Font font;
	/**
	 * {@code true} wenn der Cursor sich über diesem Objekt befindet.
	 */
	protected boolean highlighted;
	
	
	/**
	 * Konstruiert neue UiComponent mit Standardfarben für Hintergrund und Vordergrund.
	 *
	 * @param x Horizontale Position in Pixeln
	 * @param y Vertikale Position in Pixeln
	 * @param w Horizontale Größe in Pixeln
	 * @param h Vertikale Größe in Pixeln
	 * @since 0.4.7
	 */
	public UiComponent( double x,double y,double w,double h ) {
		super( x,y,w,h,null );
		foreground = Color.black;
		background = Color.black;
	}
	
	
	@Override
	public void update( double deltaTime,InputHandler input ) {
		highlighted = isPointInside( input.getMouseX(),input.getMouseY() );
	}
	
	@Override
	public void render( SimpleGraphics graphics ) {
		if( font != null )
			graphics.setFont( font );
	}
	
	
	/**
	 * @return Farbe für Objekte im Fordergrund.
	 * @since 0.4.7
	 */
	public Color getForeground() {
		return foreground;
	}
	
	/**
	 * Setzt die Farbe für Objekte im Fordergrund, beispielsweise Text.
	 *
	 * @param foreground Farbe für den Fordergrund
	 * @since 0.4.7
	 */
	public void setForeground( Color foreground ) {
		this.foreground = foreground;
	}
	
	/**
	 * @return Farbe für Objekte im Hintergrund.
	 * @since 0.4.7
	 */
	public Color getBackground() {
		return background;
	}
	
	/**
	 * Setzt die Farbe für Objekte im Hintergrund, beispielsweise Umrahmungen.
	 *
	 * @param background Farbe für den Hintergrund
	 * @since 0.4.7
	 */
	public void setBackground( Color background ) {
		this.background = background;
	}
	
	/**
	 * @return Die Schriftart für Text.
	 * @since 0.4.7
	 */
	public Font getFont() {
		return font;
	}
	
	/**
	 * Setzt die Schriftart für Text.
	 *
	 * @param font Schriftart für Text
	 * @since 0.4.7
	 */
	public void setFont( Font font ) {
		this.font = font;
	}
	
	/**
	 * @return {@code true} wenn der Cursor sich über diesem Objekt befindet.
	 * @since 0.4.7
	 */
	public boolean isHighlighted() {
		return highlighted;
	}
	
	
}
