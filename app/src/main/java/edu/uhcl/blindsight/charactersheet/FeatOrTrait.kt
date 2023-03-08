package edu.uhcl.blindsight.charactersheet

import java.lang.reflect.Method

class FeatOrTrait(
    var name: String,
    var fotDescription: String,
    var recoverOnShortRest: Boolean,
    var requirementsToMeet: List<Method>,
    var changesToCharacterSheet: List<Method>
)