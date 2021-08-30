import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { PhadminRoutingModule } from './phadmin-routing.module';

import { PhadminDermatologistComponent } from './phadmin-dermatologist/phadmin-dermatologist.component';
import { PhadminHomepageComponent } from './phadmin-homepage/phadmin-homepage.component';
import { DefineDiscountComponent } from './define-discount/define-discount.component';

import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatSelectModule } from '@angular/material/select';
import { DermatologistSearchComponent } from '../dermatologist-search/dermatologist-search.component'; 






@NgModule({
    declarations: [
       //DermatologistSearchComponent,
        PhadminHomepageComponent,
        DefineDiscountComponent,

    ],

    imports: [
        CommonModule,
        PhadminRoutingModule, 
        RouterModule,
        FormsModule,
        MatSelectModule,
       // MatFormFieldModule
        
        
      ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA]


})

export class PhadminModule {}