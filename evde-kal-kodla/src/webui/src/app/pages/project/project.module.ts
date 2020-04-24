import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProjectComponent } from './project.component';
import {ProjectRoutingModule} from "./project-routing.module";
import {ProjectService} from "../../services/shared/project.service";



@NgModule({
  declarations: [ProjectComponent],
  imports: [
    CommonModule,
    ProjectRoutingModule
  ],
  providers:[ProjectService] // Project modulunde kullanabilecegimiz local servisimiz...
})
export class ProjectModule { }
