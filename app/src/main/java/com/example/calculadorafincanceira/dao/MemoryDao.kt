package com.example.calculadorafincanceira.dao

import com.example.calculadorafincanceira.model.Memory
import java.util.*

class MemoryDao {

    fun add(memory: Memory) {
        memorys.add(memory)
    }

    fun getAll(): List<Memory> {
        return memorys.toList()
    }

    fun deleteById(id: UUID) {
        memorys.removeIf { it.id == id }
    }

    fun generateRandomId(): UUID {
        return UUID.randomUUID()
    }


    companion object {
        private val memorys = mutableListOf<Memory>()


    }
}