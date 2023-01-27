package com.example.luxsofttest.ui.screens.transaction.detail.exception

sealed class DetailsTransactionException : Exception()

class EmptyTransactionDataException : DetailsTransactionException()