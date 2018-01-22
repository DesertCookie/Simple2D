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


import java.awt.*;


/**
 * Einstellungen für den Rendering-Prozess.
 *
 * @since 0.3.4
 */
public class RenderingSettings {
	
	
	/**
	 * Voreinstellungen für Render-Qualität.
	 *
	 * @since 0.3.4
	 */
	public static final int QUALITY_DEFAULT = 0, QUALITY_LOW = 1, QUALITY_MEDIUM = 2, QUALITY_HIGH = 3;
	
	static Object ANTIALIASING = RenderingHints.VALUE_ANTIALIAS_ON;
	static Object ALPHA_INTERPOLATION = RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT;
	static Object COLOR_RENDERING = RenderingHints.VALUE_COLOR_RENDER_DEFAULT;
	static Object DITHERING = RenderingHints.VALUE_DITHER_DEFAULT;
	static Object FRACTIONALMETRICS = RenderingHints.VALUE_FRACTIONALMETRICS_DEFAULT;
	static Object INTERPOLATION = RenderingHints.VALUE_INTERPOLATION_BILINEAR;
	static Object RENDERING = RenderingHints.VALUE_RENDER_DEFAULT;
	static Object STROKE_CONTROL = RenderingHints.VALUE_STROKE_DEFAULT;
	static Object TEXT_ANTIALIASING = RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT;
	static Object TEXT_LCD_CONTRAST = 150;
	
	
	/**
	 * Konstruiert neues RenderSettings-Objekt. Interner Konstruktor.
	 *
	 * @since 0.3.4
	 */
	private RenderingSettings() { }
	
	
	/**
	 * Setzt die Render-Qualität anhand der Voreinstellungen {@code DEFAULT}, {@code LOW}, {@code MEDIUM}, {@code HIGH}.
	 *
	 * @param quality Render-Qualität
	 * @since 0.3.4
	 */
	public static void setGeneralQuality( int quality ) {
		switch( quality ) {
			case QUALITY_DEFAULT:
				ANTIALIASING = RenderingHints.VALUE_ANTIALIAS_ON;
				ALPHA_INTERPOLATION = RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT;
				COLOR_RENDERING = RenderingHints.VALUE_COLOR_RENDER_DEFAULT;
				DITHERING = RenderingHints.VALUE_DITHER_DEFAULT;
				FRACTIONALMETRICS = RenderingHints.VALUE_FRACTIONALMETRICS_DEFAULT;
				INTERPOLATION = RenderingHints.VALUE_INTERPOLATION_BILINEAR;
				RENDERING = RenderingHints.VALUE_RENDER_DEFAULT;
				STROKE_CONTROL = RenderingHints.VALUE_STROKE_DEFAULT;
				TEXT_ANTIALIASING = RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT;
				TEXT_LCD_CONTRAST = 150;
				break;
			case QUALITY_LOW:
				ANTIALIASING = RenderingHints.VALUE_ANTIALIAS_OFF;
				ALPHA_INTERPOLATION = RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED;
				COLOR_RENDERING = RenderingHints.VALUE_COLOR_RENDER_SPEED;
				DITHERING = RenderingHints.VALUE_DITHER_DISABLE;
				FRACTIONALMETRICS = RenderingHints.VALUE_FRACTIONALMETRICS_OFF;
				INTERPOLATION = RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR;
				RENDERING = RenderingHints.VALUE_RENDER_SPEED;
				STROKE_CONTROL = RenderingHints.VALUE_STROKE_DEFAULT;
				TEXT_ANTIALIASING = RenderingHints.VALUE_TEXT_ANTIALIAS_OFF;
				TEXT_LCD_CONTRAST = 150;
				break;
			case QUALITY_MEDIUM:
				ANTIALIASING = RenderingHints.VALUE_ANTIALIAS_ON;
				ALPHA_INTERPOLATION = RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED;
				COLOR_RENDERING = RenderingHints.VALUE_COLOR_RENDER_SPEED;
				DITHERING = RenderingHints.VALUE_DITHER_ENABLE;
				FRACTIONALMETRICS = RenderingHints.VALUE_FRACTIONALMETRICS_ON;
				INTERPOLATION = RenderingHints.VALUE_INTERPOLATION_BILINEAR;
				RENDERING = RenderingHints.VALUE_RENDER_SPEED;
				STROKE_CONTROL = RenderingHints.VALUE_STROKE_DEFAULT;
				TEXT_ANTIALIASING = RenderingHints.VALUE_TEXT_ANTIALIAS_OFF;
				TEXT_LCD_CONTRAST = 150;
				break;
			case QUALITY_HIGH:
				ANTIALIASING = RenderingHints.VALUE_ANTIALIAS_ON;
				ALPHA_INTERPOLATION = RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY;
				COLOR_RENDERING = RenderingHints.VALUE_COLOR_RENDER_QUALITY;
				DITHERING = RenderingHints.VALUE_DITHER_ENABLE;
				FRACTIONALMETRICS = RenderingHints.VALUE_FRACTIONALMETRICS_ON;
				INTERPOLATION = RenderingHints.VALUE_INTERPOLATION_BICUBIC;
				RENDERING = RenderingHints.VALUE_RENDER_QUALITY;
				STROKE_CONTROL = RenderingHints.VALUE_STROKE_DEFAULT;
				TEXT_ANTIALIASING = RenderingHints.VALUE_TEXT_ANTIALIAS_ON;
				break;
		}
	}
	
	
}
