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

package desertcookie.simple2d.sound;


import javax.sound.sampled.*;
import java.io.IOException;


/**
 * Klasse um Audiodateien zu AudioFiles zu laden.
 * @since 0.5.0
 */
public class AudioFileLoader {
	
	
	/**
	 * Konstruiert neuen AudioFileLoader. Interner Konstruktor.
	 * @since 0.5.0
	 */
	private AudioFileLoader() {}
	
	
	/**
	 *
	 * @param path Ort der zu ladenden Audiodatei
	 * @return AudioFile die vom angegebenen Ort geladen wurde.
	 * @since 0.5.0
	 */
	public static AudioFile loadAudioFile(String path) {
		Clip clip = null;
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(AudioFileLoader.class.getResourceAsStream( path ));
			clip = AudioSystem.getClip();
			clip.open(audioIn);
		} catch( UnsupportedAudioFileException|IOException|LineUnavailableException e ) {
			e.printStackTrace();
		}
		return new AudioFile( clip);
	}
	
	
}
