package com.example.luxsofttest.cloud.useCase.transaction

import com.example.luxsofttest.cloud.MainRepository
import com.example.luxsofttest.cloud.model.ExecutedTransactionResult
import com.example.luxsofttest.base.domain.UseCase
import com.example.luxsofttest.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetExecutedTransactionsUseCase @Inject constructor(
    private val mainRepository: MainRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<Unit, List<ExecutedTransactionResult>>(dispatcher) {

    override suspend fun execute(parameters: Unit): List<ExecutedTransactionResult> {
        return mainRepository.getExecutedTransactions()
    }
}