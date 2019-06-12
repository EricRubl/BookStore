import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Client } from 'src/app/types';

@Component({
  selector: 'app-client-modal',
  templateUrl: './client-modal.component.html',
  styleUrls: ['./client-modal.component.css']
})
export class ClientModalComponent implements OnInit {
  modalName: string;
  okButtonName: string;

  constructor(public dialogRef: MatDialogRef<ClientModalComponent>, @Inject(MAT_DIALOG_DATA) public client: Client) { }

  ngOnInit() {
    this.modalName = this.client.id ? 'Edit client' : 'Add client';
    this.okButtonName = 'Save';
  }

  onCancelClick(): void {
    this.dialogRef.close();
  }

}
