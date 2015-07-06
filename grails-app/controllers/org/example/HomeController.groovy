package org.example

class HomeController {

    def index() {

        def scenario = new IncomeScenario(title: 'foo').save()
        def deltas = [
                new IncomeDelta(name: 'name', incomeScenario: scenario),
                new IncomeDelta(name: 'name', incomeScenario: scenario)
        ]

        // the below evaluates to true, but it should be false
        def allDeltasValid = deltas.every { it.validate() }

        render text: "validation of duplicates returned: $allDeltasValid"
    }
}
