package com.example.luxsofttest.cloud.useCase.transaction

import com.example.luxsofttest.cloud.model.ExecutedTransactionResult
import com.example.luxsofttest.cloud.model.PendingTransactionResult
import com.example.luxsofttest.cloud.model.TransactionResult
import com.example.luxsofttest.base.domain.UseCase
import com.example.luxsofttest.di.DefaultDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAllTransactionsUseCase @Inject constructor(
    private val getExecutedTransactionsUseCase: GetExecutedTransactionsUseCase,
    private val getPendingTransactionsUseCase: GetPendingTransactionsUseCase,
    @DefaultDispatcher dispatcher: CoroutineDispatcher
) : UseCase<Unit, List<TransactionResult>>(dispatcher) {

    override suspend fun execute(parameters: Unit): List<TransactionResult> {
        val pendingTransactionResult = invokePendingTransactionsUseCase()
        val executedTransactionResult = invokeExecutedTransactionsUseCase()

        return pendingTransactionResult.plus(executedTransactionResult)
    }

    private suspend fun invokePendingTransactionsUseCase(): List<PendingTransactionResult> {
        return getPendingTransactionsUseCase.invoke(Unit).getOrThrow()
    }

    private suspend fun invokeExecutedTransactionsUseCase(): List<ExecutedTransactionResult> {
        return getExecutedTransactionsUseCase.invoke(Unit).getOrThrow()
    }
}