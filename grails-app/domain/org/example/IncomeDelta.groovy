package org.example

class IncomeDelta {

    IncomeScenario incomeScenario
    String name

    static constraints = {
        // within an incomeScenario the names of the income deltas must be unique
        name unique: 'incomeScenario'
    }
}