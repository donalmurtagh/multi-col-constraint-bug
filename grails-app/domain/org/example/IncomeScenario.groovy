package org.example

class IncomeScenario {

    String title

    Collection<IncomeDelta> getItems() {
        IncomeDelta.findAllByIncomeScenario(this)
    }
}
