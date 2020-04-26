import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SubjectComponent } from './subject.component';
import {SubjectRoutingModule} from "./subject-routing.module";
import {SubjectService} from "../../services/shared/subject.service";
import {SharedModule} from "../../shared/shared.module";



@NgModule({
  declarations: [SubjectComponent],
  imports: [
    CommonModule,
    SubjectRoutingModule,
    SharedModule
  ],
  providers:[SubjectService]  // Subject Modulunde kullanacagimiz lokal servisimiz...
})
export class SubjectModule { }
