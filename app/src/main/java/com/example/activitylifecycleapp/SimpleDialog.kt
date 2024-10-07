package com.example.activitylifecycleapp

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class SimpleDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireActivity())
            .setMessage("This is a simple dialog")
            .setPositiveButton("Close") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
    }
}
