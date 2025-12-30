package com.TugasAkhir.pmobile.utils

import com.google.firebase.firestore.FirebaseFirestore

object FirebaseUtil {
    val db: FirebaseFirestore by lazy {
        FirebaseFirestore.getInstance()
    }
}
