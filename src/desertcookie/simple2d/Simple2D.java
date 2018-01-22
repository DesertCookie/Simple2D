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

package desertcookie.simple2d;


/**
 * Diese Klasse enthält Informationen über Simple2D, beispielsweise die aktuelle Versionsnummer.
 *
 * @since 0.1.9
 */
public class Simple2D {
	
	
	/**
	 * Aktuelle Version von Simple2D, aufgeteilt in {@code major}, {@code minor} und {@code build}.
	 *
	 * @since 0.1.9
	 */
	public static final int VERSION_MAJOR = 0, VERSION_MINOR = 5, VERSION_BUILD = 0;
	/**
	 * Aktuelle Version von Simple2D als String. Formatiert zu {@code major.minor.build}.
	 *
	 * @since 0.1.9
	 */
	public static final String VERSION_STRING = String.format( "%s.%s.%s",VERSION_MAJOR,VERSION_MINOR,VERSION_BUILD );
	/**
	 * Datum, an welchem Simple2D das letzte mal geupdated wurde als String. Formatiert zu {@code dd.mm.yyyy}.
	 *
	 * @since 0.3.4
	 */
	public static final String DATE_UPDATED = "22.01.2018";
	
	
	/**
	 * Leerer Konstruktor.
	 *
	 * @since 0.1.9
	 */
	private Simple2D() { }
	
	
}
