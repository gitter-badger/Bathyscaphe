/*
 * Copyright (c) 2022 Michael Belivanakis a.k.a. MikeNakis, michael.gr
 *
 * Licensed under a dual-license scheme; see LICENSE.md for details.
 * You may not use this file except in compliance with one of the licenses.
 */

package io.github.mikenakis.bathyscaphe.internal.type.assessments.nonimmutable.provisory;

import io.github.mikenakis.bathyscaphe.internal.helpers.Helpers;
import io.github.mikenakis.bathyscaphe.internal.assessments.Assessment;

import java.util.List;

/**
 * Signifies that a class is provisory due to multiple reasons.
 *
 * @author michael.gr
 */
public final class MultiReasonProvisoryTypeAssessment extends ProvisoryTypeAssessment
{
	public final List<ProvisoryTypeAssessment> provisoryReasons;

	public MultiReasonProvisoryTypeAssessment( Class<?> jvmClass, List<ProvisoryTypeAssessment> provisoryReasons )
	{
		super( jvmClass );
		assert Helpers.isClass( jvmClass );
		this.provisoryReasons = provisoryReasons;
	}

	@Override public List<Assessment> children() { return List.copyOf( provisoryReasons ); }
}
