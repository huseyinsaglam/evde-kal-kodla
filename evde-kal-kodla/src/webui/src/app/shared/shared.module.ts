import { NgModule } from '@angular/core';
import {TranslateModule} from "@ngx-translate/core";
import {ModalModule} from "ngx-bootstrap/modal";
import {ReactiveFormsModule} from "@angular/forms";



@NgModule({
  exports: [
    TranslateModule,
    ModalModule,
    ReactiveFormsModule
  ]
})
export class SharedModule { }
