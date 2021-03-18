package com.garden.menagarden.ui.reservas

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.telephony.PhoneNumberUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.garden.menagarden.DatePickerFragment
import com.garden.menagarden.MainActivity
import com.garden.menagarden.TimePickerFragment
import com.garden.menagarden.databinding.FragmentReservasBinding

class ReservasFragment : Fragment() {


    private  var _binding: FragmentReservasBinding?=null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {


        _binding = FragmentReservasBinding.inflate(inflater, container, false)


        (activity as MainActivity).hideFloatingActionButton() // llamada al MainActivity para esconder el botón flotante


        binding.ETdate.setOnClickListener { showDatePickerDialog() } //listener para el editText del DatePicker
        binding.ETtime.setOnClickListener { showTimePickerDialog() } //listener para el editText del TimePicker


        //botón de Phone

        binding.btPhone.setOnClickListener {

            val phone = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+34952520541"))

            startActivity(phone)

        }


        //SUBRAYADO PARA LOS TEXTVIEW
        binding.reservaAnombrede.paint.isUnderlineText = true
        binding.comensalesReserva.paint.isUnderlineText = true
        binding.fechareserva.paint.isUnderlineText = true
        binding.horareserva.paint.isUnderlineText = true
        binding.observaciones.paint.isUnderlineText = true




        binding.SendEmailBtn.setOnClickListener { // botón enviar email

            val recipient = binding.emailGarden.text.toString().trim()
            val subject = binding.ETasunto.text.toString().trim()
            val nombre = binding.ETname.text.toString().trim()
            val phone = binding.ETtelefono.text.toString().trim()
            val fecha = binding.ETdate.text.toString().trim()
            val hora = binding.ETtime.text.toString().trim()
            val pax = binding.ETpax.text.toString().trim()
            val observaciones = binding.ETobservaciones.text.toString().trim()

            sendEmail(recipient, subject, nombre, phone, fecha, hora, pax, observaciones)


        }

        return binding.root

    }


    // DATE PICKER

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(parentFragmentManager, "datePicker")
    }


    @SuppressLint("SetTextI18n")
    private fun onDateSelected(day: Int, month: Int, year: Int) {
        val selectedMonth =
            month + 1 // por defecto en java el calendario empieza en 0, con esta variable devuelve el mes correcto sumando +1
        binding.ETdate.setText("$day / $selectedMonth / $year")
    }


    // TIME PICKER

    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment { onTimeSelected(it) }
        timePicker.show(parentFragmentManager, "timePicker")
    }

    private fun onTimeSelected(time: String) {
        binding.ETtime.setText(time)
    }


    // Send message by email or whatsapp

    private fun sendEmail(
        recipient: String,
        subject: String,
        nombre: String,
        phone: String,
        fecha: String,
        hora: String,
        pax: String,
        observaciones: String

    ) { // llamada a la función enviar email

        val miIntent = Intent(Intent.ACTION_SEND_MULTIPLE)
        val smsNumber = "34952520541"

        miIntent.data = Uri.parse("mailto:")
        miIntent.type = "text/plain"
        miIntent.putExtra(
            "jid",
            PhoneNumberUtils.stripSeparators(smsNumber) + "@s.whatsapp.net"

        )//prefijo teléfono de país sin el +

        miIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        miIntent.putExtra(Intent.EXTRA_SUBJECT, "".plus(subject))   // EN EL ASUNTO DEL EMAIL
        miIntent.putExtra(
            Intent.EXTRA_TEXT, "RESERVA DE: ".plus(nombre).plus("\n").plus("\n").plus("Nº TELEF: ").plus(phone)
                .plus("\n").plus("\n").plus("FECHA: ").plus(fecha)
                .plus("\n").plus("\n").plus("HORA: ").plus(hora)
                .plus("\n").plus("\n").plus("Nº PAX: ").plus(pax)
                .plus("\n").plus("\n").plus("OBSERVACIONES: ").plus(observaciones)


        )


        try {
            startActivity(Intent.createChooser(miIntent, "Email or Whatsapp"))

        } catch (e: Exception) {

            Toast.makeText(requireActivity(), e.message, Toast.LENGTH_LONG).show()


        }


    }


}






