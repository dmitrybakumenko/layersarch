package com.example.dmitrybak.myjetpack.exceptions

import java.security.InvalidParameterException

class ExceptionValidation(val paramId: Int, val msg: String) : InvalidParameterException()