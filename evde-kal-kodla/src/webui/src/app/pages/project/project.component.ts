import {Component, OnInit, TemplateRef} from '@angular/core';
import {ProjectService} from "../../services/shared/project.service";
import {Page} from "../../common/page";
import {Project} from "../../common/project.model";
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss']
})
export class ProjectComponent implements OnInit {

  modalRef: BsModalRef;
  projectForm: FormGroup;

  page = new Page();
  cols = [
    {prop: 'id', name: 'No'},
    {prop: 'projectName', name: 'Project Name', sortable: false},
    {prop: 'projectCode', name: 'Project Code', sortable: false},
  ];

  rows =[];


  constructor(private projectService: ProjectService,public modalService: BsModalService,
              private formBuilder: FormBuilder) {}

  ngOnInit() {

    this.setPage({ offset: 0 });

    /*https://angular.io/guide/form-validation*/
    this.projectForm = this.formBuilder.group({
      'projectCode': [null, [Validators.required, Validators.minLength(2), Validators.maxLength(10)]],
      'projectName': [null, [Validators.required, Validators.minLength(4)]],
    });

  }

  get f() {
    return this.projectForm.controls
  }


  setPage(pageInfo) {
    this.page.page = pageInfo.offset;
    this.projectService.getAll(this.page).subscribe(pagedData => {
      this.page.size = pagedData.size;
      this.page.page = pagedData.page;
      this.page.totalElements = pagedData.totalElements;
      this.rows = pagedData.content;

    });
  }

  // https://valor-software.com/ngx-bootstrap/#/modals
  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }


  /* Validatation islemi yapıp ondan sonra kayıt etme islemi yapma*/
  saveProject() {


    if (!this.projectForm.valid)
      return;

    this.projectService.createProject(this.projectForm.value).subscribe(
      response => {


        console.log();


      }
    )
    this.setPage({offset: 0});
    this.closeAndResetModal();

  }

  /* Hem formun datasını resetleme hemde datamızı gizleme islemi*/
  closeAndResetModal() {
    this.projectForm.reset();
    this.modalRef.hide();
  }
}
