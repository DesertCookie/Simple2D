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


import desertcookie.simple2d.input.InputHandler;
import desertcookie.simple2d.input.Mouse;
import desertcookie.simple2d.rendering.SimpleGraphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Ui-Komponente zur Darstellung eines Buttons.
 *
 * @since 0.4.7
 */
public class Button extends UiComponent {
	
	
	private double cornerRounding;
	private String text;
	private ActionListener actionListener;
	private boolean pressed;
	
	
	/**
	 * Konstruiert neuen Button.
	 *
	 * @param x    Horizontale Position in Pixeln
	 * @param y    Vertikale Position in Pixeln
	 * @param w    Horizontale Größe in Pixeln
	 * @param h    Vertikale Größe in Pixeln
	 * @param text Text dieses Buttons
	 * @since 0.4.7
	 */
	public Button( double x,double y,double w,double h,String text ) {
		super( x,y,w,h );
		this.text = text;
	}
	
	
	@Override
	public void update( double deltaTime,InputHandler input ) {
		super.update( deltaTime,input );
		if( input.isButtonDown( Mouse.LEFT ) )
			pressed = true;
		else
			pressed = false;
		if( highlighted && pressed && actionListener != null )
			actionListener.actionPerformed( new ActionEvent( this,ActionEvent.ACTION_PERFORMED,"Button pressed" ) );
	}
	
	@Override
	public void render( SimpleGraphics graphics ) {
		super.render( graphics );
		graphics.setColor( background );
		if( highlighted && pressed )
			graphics.drawRoundRect( x + 1,y + 1,w - 2,h - 2,cornerRounding,cornerRounding );
		else if( highlighted && !pressed )
			graphics.drawRoundRect( x - 1,y - 1,w + 2,h + 2,cornerRounding,cornerRounding );
		else
			graphics.drawRoundRect( x,y,w,h,cornerRounding,cornerRounding );
		graphics.setColor( foreground );
		graphics.drawString( text,x,y,w,h );
	}
	
	
	/**
	 * @return Stärke der Ecken-Rundung.
	 * @since 0.4.7
	 */
	public double getCornerRounding() {
		return cornerRounding;
	}
	
	/**
	 * Setzt die Stärke der Ecken-Rundung. {@code 0} für spitze Ecken.
	 *
	 * @param cornerRounding Stärke Ecken-Rundung
	 * @since 0.4.7
	 */
	public void setCornerRounding( double cornerRounding ) {
		this.cornerRounding = cornerRounding;
	}
	
	/**
	 * @return Text dieses Buttons.
	 * @since 0.4.7
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Setzt den Text dieses Buttons.
	 *
	 * @param text Text dieses Buttons
	 * @since 0.4.7
	 */
	public void setText( String text ) {
		this.text = text;
	}
	
	/**
	 * Fügt dem Button einen ActionListener hinzu, der aktiviert wird, wenn der Cursor über dem Objekt ist und die linke Maustaste gedrückt wird.
	 *
	 * @param actionListener ActionListener der genutzt werden soll
	 * @since 0.4.7
	 */
	public void addActionListener( ActionListener actionListener ) {
		this.actionListener = actionListener;
	}
	
	
}
