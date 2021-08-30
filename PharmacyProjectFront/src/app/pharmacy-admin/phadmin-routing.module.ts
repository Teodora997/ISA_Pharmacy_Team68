import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PhadminDermatologistComponent } from './phadmin-dermatologist/phadmin-dermatologist.component';

import {PhadminHomepageComponent} from './phadmin-homepage/phadmin-homepage.component';
import { DefineDiscountComponent } from './define-discount/define-discount.component';
import { DermatologistSearchComponent } from '../dermatologist-search/dermatologist-search.component';





const routes: Routes = [
{ path: 'phadmin-homepage', component: PhadminHomepageComponent },
{ path: 'dermatologist-search', component: DermatologistSearchComponent },
{ path: 'define-discount', component: DefineDiscountComponent },




];


@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })
  export class PhadminRoutingModule { }




