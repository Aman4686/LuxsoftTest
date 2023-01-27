package com.example.luxsofttest.cloud.useCase.card

import com.example.luxsofttest.cloud.MainRepository
import com.example.luxsofttest.cloud.model.CardResult
import com.example.luxsofttest.base.domain.UseCase
import com.example.luxsofttest.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetCardsUseCase @Inject constructor(
    private val mainRepository: MainRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<Unit, List<CardResult>>(dispatcher) {

    override suspend fun execute(parameters: Unit): List<CardResult> {
        return mainRepository.getCards()
    }
}