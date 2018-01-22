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

package desertcookie.simple2d.rendering;


import desertcookie.simple2d.core.Game;
import desertcookie.simple2d.textures.Texture;

import java.awt.*;


/**
 * Schnittstelle zum Rendern von verschiedensten Formen und Texturen.
 *
 * @since 0.1.9
 */
public class SimpleGraphics {
	
	
	private Graphics2D graphics;
	private double scale;
	
	
	/**
	 * Konstruiert neues SimpleGraphics-Objekt. Interner Konstruktor.
	 *
	 * @param graphics Graphics2D-Objekt das benutzt werden soll
	 * @since 0.1.9
	 */
	public SimpleGraphics( Graphics2D graphics ) {
		this.graphics = graphics;
		scale = 1.0;
		reloadRenderingSettings();
	}
	
	
	/**
	 * @return Skalierungsfaktor für Positionen und Größen.
	 * @since 0.3.4
	 */
	public double getScale() {
		return scale;
	}
	
	/**
	 * Setzt den Skalierungsfaktor für Positionen und Größen.
	 *
	 * @param scale Skalierungsfaktor
	 * @since 0.3.4
	 */
	public void setScale( double scale ) {
		this.scale = scale;
	}
	
	/**
	 * @return Aktuelle verwendete Farbe.
	 * @since 0.3.4
	 */
	public Color getColor() {
		return graphics.getColor();
	}
	
	/**
	 * Setzt die aktuelle Farbe.
	 *
	 * @param color Farbe die verwendet werden soll
	 * @since 0.1.9
	 */
	public void setColor( Color color ) {
		graphics.setColor( color );
	}
	
	/**
	 * @return Aktuelle Schriftart.
	 * @since 0.3.4
	 */
	public Font getFont() {
		return graphics.getFont();
	}
	
	/**
	 * Setzt die aktuelle Schriftart.
	 *
	 * @param font Schriftart die verwendet werden soll
	 * @since 0.3.4
	 */
	public void setFont( Font font ) {
		graphics.setFont( font );
	}
	
	
	/**
	 * Rendert ein Rechteck an der angegebenen Stelle mit der angegebenen Größe.
	 *
	 * @param x Horizontale Position in Pixeln
	 * @param y Vertikale Position in Pixeln
	 * @param w Horizontale Größe in Pixeln
	 * @param h Vertikale Größe in Pixeln
	 * @since 0.4.7
	 */
	public void drawRect( double x,double y,double w,double h ) {
		graphics.drawRect( (int)(x * scale),(int)(y * scale),(int)(w * scale),(int)(h * scale) );
	}
	
	/**
	 * Rendert ein gefülltes Rechteck an der angegebenen Stelle mit der angegebenen Größe.
	 *
	 * @param x Horizontale Position in Pixeln
	 * @param y Vertikale Position in Pixeln
	 * @param w Horizontale Größe in Pixeln
	 * @param h Vertikale Größe in Pixeln
	 * @since 0.4.7
	 */
	public void fillRect( double x,double y,double w,double h ) {
		graphics.fillRect( (int)(x * scale),(int)(y * scale),(int)(w * scale),(int)(h * scale) );
	}
	
	/**
	 * Rendert ein Rechteck mit abgerundeten Ecken an der angegebenen Stelle mit der angegebenen Größe.
	 *
	 * @param x    Horizontale Position in Pixeln
	 * @param y    Vertikale Position in Pixeln
	 * @param w    Horizontale Größe in Pixeln
	 * @param h    Vertikale Größe in Pixeln
	 * @param arcW Stärke der horizontalen Ecken-Rundung
	 * @param arcH Stärke der vertikalen Ecken-Rundung
	 * @since 0.4.7
	 */
	public void drawRoundRect( double x,double y,double w,double h,double arcW,double arcH ) {
		graphics.drawRoundRect( (int)(x * scale),(int)(y * scale),(int)(w * scale),(int)(h * scale),(int)(arcW * scale),(int)(arcH * scale) );
	}
	
	/**
	 * Rendert ein gefülltes Rechteck mit abgerundeten Ecken an der angegebenen Stelle mit der angegebenen Größe.
	 *
	 * @param x    Horizontale Position in Pixeln
	 * @param y    Vertikale Position in Pixeln
	 * @param w    Horizontale Größe in Pixeln
	 * @param h    Vertikale Größe in Pixeln
	 * @param arcW Stärke der horizontalen Ecken-Rundung
	 * @param arcH Stärke der vertikalen Ecken-Rundung
	 * @since 0.4.7
	 */
	public void fillRoundRect( double x,double y,double w,double h,double arcW,double arcH ) {
		graphics.fillRoundRect( (int)(x * scale),(int)(y * scale),(int)(w * scale),(int)(h * scale),(int)(arcW * scale),(int)(arcH * scale) );
	}
	
	/**
	 * Rendert den angegebenen Text zentriert im angegebenen Bereich.
	 *
	 * @param s Text der gerendert werden soll
	 * @param x Horizontale Position des Bereichs in Pixeln
	 * @param y Vertikale Position des Bereichs in Pixeln
	 * @param w Horizontale Größe des Bereichs in Pixeln
	 * @param h Vertikale Größe des Bereichs in Pixeln
	 * @since 0.3.4
	 */
	public void drawString( String s,double x,double y,double w,double h ) {
		FontMetrics metrics = graphics.getFontMetrics( graphics.getFont() );
		x = x + (w - metrics.stringWidth( s )) / 2;
		y = y + ((h - metrics.getHeight()) / 2) + metrics.getAscent();
		graphics.drawString( s,(int)(x * scale),(int)(y * scale) );
	}
	
	/**
	 * Rendert den angegebenen Text an der angegebenen Position (Baseline-Rendering).
	 *
	 * @param s Text der gerendert werden soll
	 * @param x Horizontale Position in Pixeln
	 * @param y Vertikale Position in Pixeln
	 * @since 0.3.4
	 */
	public void drawString( String s,double x,double y ) {
		graphics.drawString( s,(int)(x * scale),(int)(y * scale) );
	}
	
	/**
	 * Rendert die angegebene Textur an der angegebenen Stelle mit der angegebenen Größe.
	 *
	 * @param texture Textur die gerendert werden soll
	 * @param x       Horizontale Position in Pixeln
	 * @param y       Vertikale Position in Pixeln
	 * @param w       Horizontale Größe in Pixeln
	 * @param h       Vertikal Größe in Pixeln
	 * @since 0.1.9
	 */
	public void drawTexture( Texture texture,double x,double y,double w,double h ) {
		graphics.drawImage( texture.getImage(),(int)(x * scale),(int)(y * scale),(int)(w * scale),(int)(h * scale),null );
	}
	
	/**
	 * Rendert die angegebene Textur an der angegebenen Stelle mit der Größe der Textur.
	 *
	 * @param texture Textur die gerendert werden soll
	 * @param x       Horizontale Position in Pixeln
	 * @param y       Vertikale Position in Pixeln
	 * @since 0.1.9
	 */
	public void drawTexture( Texture texture,double x,double y ) {
		drawTexture( texture,x,y,texture.getImage().getWidth(),texture.getImage().getHeight() );
	}
	
	/**
	 * Lädt die Rendereinstellungen neu. Diese Methode sollte aufgerufen werden, nachdem ein Wert in der RenderingSettings-Klasse geändert wurde.
	 *
	 * @since 0.3.4
	 */
	public void reloadRenderingSettings() {
		graphics.setRenderingHint( RenderingHints.KEY_ANTIALIASING,RenderingSettings.ANTIALIASING );
		graphics.setRenderingHint( RenderingHints.KEY_ALPHA_INTERPOLATION,RenderingSettings.ALPHA_INTERPOLATION );
		graphics.setRenderingHint( RenderingHints.KEY_COLOR_RENDERING,RenderingSettings.COLOR_RENDERING );
		graphics.setRenderingHint( RenderingHints.KEY_DITHERING,RenderingSettings.DITHERING );
		graphics.setRenderingHint( RenderingHints.KEY_FRACTIONALMETRICS,RenderingSettings.FRACTIONALMETRICS );
		graphics.setRenderingHint( RenderingHints.KEY_INTERPOLATION,RenderingSettings.INTERPOLATION );
		graphics.setRenderingHint( RenderingHints.KEY_RENDERING,RenderingSettings.RENDERING );
		graphics.setRenderingHint( RenderingHints.KEY_STROKE_CONTROL,RenderingSettings.STROKE_CONTROL );
		graphics.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING,RenderingSettings.TEXT_ANTIALIASING );
		graphics.setRenderingHint( RenderingHints.KEY_TEXT_LCD_CONTRAST,RenderingSettings.TEXT_LCD_CONTRAST );
	}
	
	/**
	 * Setzt den Render-Buffer zurück. Interne Methode.
	 *
	 * @since 0.3.4
	 */
	public void resetBuffer() {
		Color originalColor = graphics.getColor();
		graphics.setColor( Color.white );
		graphics.fillRect( 0,0,Game.getDisplay().getWidth(),Game.getDisplay().getHeight() );
		graphics.setColor( originalColor );
	}
	
	
}
