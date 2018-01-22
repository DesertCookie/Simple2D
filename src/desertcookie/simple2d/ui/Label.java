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


import desertcookie.simple2d.rendering.SimpleGraphics;


/**
 * Ui-Komponente zum Darstellen von Text.
 *
 * @since 0.4.7
 */
public class Label extends UiComponent {
	
	
	private String text;
	
	
	/**
	 * Konstruiert neues Label.
	 *
	 * @param x    Horizontale Position in Pixeln
	 * @param y    Vertikale Position in Pixeln
	 * @param w    Horizontale Größe in Pixeln
	 * @param h    Vertikale Größe in Pixeln
	 * @param text Text dieses Labels
	 * @since 0.4.7
	 */
	public Label( double x,double y,double w,double h,String text ) {
		super( x,y,w,h );
		this.text = text;
	}
	
	
	@Override
	public void render( SimpleGraphics graphics ) {
		super.render( graphics );
		graphics.setColor( foreground );
		graphics.drawString( text,x,y,w,h );
	}
	
	
	/**
	 * @return Text dieses Labels.
	 * @since 0.4.7
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Setzt den Text dieses Labels.
	 *
	 * @param text Text dieses Labels
	 * @since 0.4.7
	 */
	public void setText( String text ) {
		this.text = text;
	}
	
	
}
