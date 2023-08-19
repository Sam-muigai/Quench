/*
 * Copyright (C)2023 Brandy Odhiambo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.brandyodhiambo.statistics.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.brandyodhiambo.common.domain.model.DailyStatistics
import com.brandyodhiambo.common.domain.repository.DailyStatisticsRepository
import com.brandyodhiambo.dao.DailyStatisticsDao
import com.brandyodhiambo.statistics.data.mapper.toDailyStatistics
import com.brandyodhiambo.statistics.data.mapper.toDailyStatisticsEntity

class DailyStatisticsRepositoryImpl(
    private val dailyStatisticsDao: DailyStatisticsDao
) : DailyStatisticsRepository {
    override suspend fun insertDailyStatistics(dailyStatistics: DailyStatistics) {
        dailyStatisticsDao.insertDailyStatistic(dailyStatistics.toDailyStatisticsEntity())
    }

    override suspend fun updateDailyStatistics(dailyStatistics: DailyStatistics) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteDailyStatistics(dailyStatistics: DailyStatistics) {
        dailyStatisticsDao.deleteDailyStatistic(dailyStatistics.toDailyStatisticsEntity())
    }

    override suspend fun deleteAllDailyStatistics() {
        dailyStatisticsDao.deleteAllDailyStatistics()
    }

    override fun getDailyStatistics(): LiveData<List<DailyStatistics>?> {
        return Transformations.map(dailyStatisticsDao.getDailyStatistics()) { dailyStatisticsEntity ->
            dailyStatisticsEntity?.map { it.toDailyStatistics() }
        }
    }
}
