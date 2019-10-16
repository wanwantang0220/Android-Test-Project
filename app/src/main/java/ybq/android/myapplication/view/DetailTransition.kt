package ybq.android.myapplication.view

import android.transition.ChangeBounds
import android.transition.ChangeImageTransform
import android.transition.ChangeTransform
import android.transition.TransitionSet

class DetailTransition : TransitionSet() {

    init {
        ordering = TransitionSet.ORDERING_TOGETHER
        addTransition(ChangeBounds()).addTransition(ChangeTransform()).addTransition(ChangeImageTransform())
    }
}