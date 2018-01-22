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

package desertcookie.simple2d.textures;


import desertcookie.util.ExceptionHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * Klasse um Bilddateien zu Texturen zu laden.
 *
 * @since 0.1.9
 */
public class TextureLoader {
	
	
	/**
	 * @param path Pfad und Dateiname der Bilddatei
	 * @return Zu Textur geladene Bilddatei.
	 * @since 0.1.9
	 */
	public static Texture loadTexture( String path ) {
		try {
			return new Texture( toCompatibleImage( ImageIO.read( TextureLoader.class.getResourceAsStream( path ) ) ) );
		} catch( IOException e ) {
			ExceptionHandler.handle( e,"Fehler beim laden einer Texturdatei",false );
		}
		return null;
	}
	
	/**
	 * @param image Bild das konvertiert werden soll
	 * @return Das zu einem mit diesem System kopatibleren Bildformat angegebene Bild.
	 * @since 0.1.9
	 */
	public static BufferedImage toCompatibleImage( BufferedImage image ) {
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		
		if( image.getColorModel().equals( gc.getColorModel() ) )
			return image;
		
		BufferedImage newImage = gc.createCompatibleImage( image.getWidth(),image.getHeight(),image.getTransparency() );
		Graphics2D graphics = newImage.createGraphics();
		graphics.drawImage( image,0,0,null );
		graphics.dispose();
		
		return newImage;
	}
	
	
}
