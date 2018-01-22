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


import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


/**
 * Interne Klasse für Mausbewegungen.
 *
 * @since 0.4.7
 */
class MouseMovement extends MouseMotionAdapter {
	
	
	/**
	 * Konstruiert neues MouseMovement-Objekt. Interner Konstruktor.
	 *
	 * @since 0.4.7
	 */
	MouseMovement() { }
	
	
	@Override
	public void mouseMoved( MouseEvent e ) {
		super.mouseMoved( e );
		InputHandler.mouseX = e.getX();
		InputHandler.mouseY = e.getY();
	}
	
	@Override
	public void mouseDragged( MouseEvent e ) {
		super.mouseDragged( e );
		InputHandler.mouseXDragDelta = e.getX() - InputHandler.mouseXDragStart;
		InputHandler.mouseYDragDelta = e.getY() - InputHandler.mouseYDragStart;
	}
	
	
}
