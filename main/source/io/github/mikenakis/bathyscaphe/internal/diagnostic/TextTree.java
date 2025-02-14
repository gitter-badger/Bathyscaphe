/*
 * Copyright (c) 2022 Michael Belivanakis a.k.a. MikeNakis, michael.gr
 *
 * Licensed under a dual-license scheme; see LICENSE.md for details.
 * You may not use this file except in compliance with one of the licenses.
 */

package io.github.mikenakis.bathyscaphe.internal.diagnostic;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Utility class for generating nice looking trees.
 *
 * @author michael.gr
 */
public final class TextTree
{
	private TextTree() { }

	private static final String midLeaf = "├─";
	private static final String endLeaf = "└─";
	private static final String midNode = "│ ";
	private static final String endNode = "  ";
	private static final String terminal = "■ ";

	public static <T> void tree( T rootNode, Function<T,Iterable<? extends T>> breeder, Function<T,String> stringizer, Consumer<String> emitter )
	{
		StringBuilder stringBuilder = new StringBuilder();
		printTreeRecursive( stringBuilder, "", rootNode, "", breeder, stringizer, emitter );
	}

	private static <T> void printTreeRecursive( StringBuilder stringBuilder, String parentPrefix, T node, String childPrefix, //
		Function<T,Iterable<? extends T>> breeder, Function<T,String> stringizer, Consumer<String> emitter )
	{
		int position = stringBuilder.length();
		stringBuilder.append( parentPrefix ).append( terminal );
		stringBuilder.append( stringizer.apply( node ) );
		emitter.accept( stringBuilder.toString() );
		stringBuilder.setLength( position );
		stringBuilder.append( childPrefix );
		Iterator<? extends T> iterator = breeder.apply( node ).iterator();
		while( iterator.hasNext() )
		{
			T childNode = iterator.next();
			boolean mid = iterator.hasNext();
			printTreeRecursive( stringBuilder, mid ? midLeaf : endLeaf, childNode, mid ? midNode : endNode, breeder, stringizer, emitter );
		}
		stringBuilder.setLength( position );
	}
}
