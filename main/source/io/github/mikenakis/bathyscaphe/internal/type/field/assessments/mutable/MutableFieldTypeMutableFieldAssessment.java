/*
 * Copyright (c) 2022 Michael Belivanakis a.k.a. MikeNakis, michael.gr
 *
 * Licensed under a dual-license scheme; see LICENSE.md for details.
 * You may not use this file except in compliance with one of the licenses.
 */

package io.github.mikenakis.bathyscaphe.internal.type.field.assessments.mutable;

import io.github.mikenakis.bathyscaphe.internal.assessments.Assessment;
import io.github.mikenakis.bathyscaphe.internal.type.assessments.nonimmutable.mutable.MutableTypeAssessment;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Signifies that a field is mutable because even though it is invariable, it is of a mutable type.
 *
 * @author michael.gr
 */
public final class MutableFieldTypeMutableFieldAssessment extends MutableFieldAssessment
{
	public final MutableTypeAssessment fieldTypeAssessment;

	public MutableFieldTypeMutableFieldAssessment( Field field, MutableTypeAssessment fieldTypeAssessment )
	{
		super( field );
		assert field.getType() == fieldTypeAssessment.type;
		this.fieldTypeAssessment = fieldTypeAssessment;
	}

	@Override public List<Assessment> children() { return List.of( fieldTypeAssessment ); }
}
