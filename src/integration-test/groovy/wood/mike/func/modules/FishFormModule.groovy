package wood.mike.func.modules

import geb.Module

class FishFormModule extends Module {

    static content = {
        lakeSelector(required: true){ $( '#lake' ) }
        fishNameInput(required: true){ $('#name') }
        fishTypeInput(required: true){ $('#type') }
        submitButton(required: true){ $('#create') }
    }

    void fillInForm( lake = 1, name = 'Greta', type = 'Gudgeon' ) {
        lakeSelector.value(lake)
        fishNameInput.value(name)
        fishTypeInput.value(type)
    }
}
