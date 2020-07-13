package com.example.showcars.util

import java.io.IOException

class ApiException(message: String, val code: Int) : IOException(message)

class NoInternetException(message: String) : IOException(message)