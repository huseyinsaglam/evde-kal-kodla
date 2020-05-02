import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {ProjectService} from "../../services/shared/project.service";
import {Page} from "../../common/page";
import {Project} from "../../common/project.model";
import {BsModalService, BsModalRef} from 'ngx-bootstrap/modal';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ConfirmationComponent} from "../../shared/confirmation/confirmation.component";

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss']
})
export class ProjectComponent implements OnInit {


  @ViewChild('tplProjectDeleteCell', {static: true}) tplProjectDeleteCell: TemplateRef<any>;
  modalRef: BsModalRef;
  projectForm: FormGroup;

  page = new Page();
  rows = [];
  columns = [];
  loadingIndicator = true;
  reorderable = true;


  constructor(private projectService: ProjectService, public modalService: BsModalService,
              private formBuilder: FormBuilder) {


    this.fetch(data => {
      this.rows = data;
    });


  }


  ngOnInit() {


    this.columns = [{prop: 'id'}, {name: 'Project Name'}, {name: 'Project Code', sortable: false},
      {prop: 'id', name: 'Actions', cellTemplate: this.tplProjectDeleteCell, flexGrow: 1, sortable: false}
    ];


    /*https://angular.io/guide/form-validation*/
    this.projectForm = this.formBuilder.group({
      'projectCode': [null, [Validators.required, Validators.minLength(2), Validators.maxLength(10)]],
      'projectName': [null, [Validators.required, Validators.minLength(4)]],
    });

  }

  get f() {
    return this.projectForm.controls
  }


  // https://www.positronx.io/create-ionic-data-table-with-ngx-datatable/
  fetch(cb) {
    this.projectService.getAll(this.page).subscribe(
      projectData => {
        this.page.size = projectData.size;
        this.page.page = projectData.page;
        this.page.totalElements = projectData.totalElements;
        this.rows = projectData.content;

      }
    )
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
    this.closeAndResetModal();
  }

  /* Hem formun datasını resetleme hemde datamızı gizleme islemi*/
  closeAndResetModal() {
    this.projectForm.reset();
    this.modalRef.hide();
  }


  showProjectDeleteConfirmation(value): void {
    const modal = this.modalService.show(ConfirmationComponent);
    (<ConfirmationComponent>modal.content).showConfirmation(
      'Silmeyi Onayliyormusunuz ?',
      'Projeyi Silmek istediğinizden eminmisiniz ? '
    );

    (<ConfirmationComponent>modal.content).onClose.subscribe(result => {
        if (result === true) {
          this.projectService.delete(value).subscribe(response => {
            if (response === true) {

              this.fetch({offset: 0}); // Pagination yenileme yap
            }
          });
        } else if (result === false) {

        }
      }
    );
  }
}
