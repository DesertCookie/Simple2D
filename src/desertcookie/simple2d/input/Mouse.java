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

package desertcookie.simple2d.input;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;


/**
 * Repräsentation der Maus.
 *
 * @since 0.3.4
 */
public class Mouse extends MouseAdapter {
	
	
	/**
	 * Standard Maustasten.
	 *
	 * @since 0.3.4
	 */
	public static final int LEFT = MouseEvent.BUTTON1, MIDDLE = MouseEvent.BUTTON2, RIGHT = MouseEvent.BUTTON3;
	
	
	/**
	 * Konstruiert neue Maus. Interner Konstruktor.
	 *
	 * @since 0.3.4
	 */
	Mouse() { }
	
	
	@Override
	public void mousePressed( MouseEvent e ) {
		super.mousePressed( e );
		InputHandler.mouseButtons[e.getButton()] = true;
		InputHandler.mouseXDragStart = InputHandler.mouseX;
		InputHandler.mouseYDragStart = InputHandler.mouseY;
	}
	
	@Override
	public void mouseReleased( MouseEvent e ) {
		super.mousePressed( e );
		InputHandler.mouseButtons[e.getButton()] = false;
		InputHandler.mouseXDragStart = 0;
		InputHandler.mouseYDragStart = 0;
	}
	
	@Override
	public void mouseWheelMoved( MouseWheelEvent e ) {
		super.mouseWheelMoved( e );
		InputHandler.mouseWheelDelta = e.getWheelRotation();
		System.out.println( InputHandler.mouseWheelDelta );
	}
	
	
}
