package com.example.sportinfokmp.ui.search

import com.example.sportinfokmp.ui.search.SearchResult
import kotlinx.coroutines.flow.Flow

interface SearchContentsRepository {

    fun searchContents(searchQuery: String): Flow<SearchResult>

}