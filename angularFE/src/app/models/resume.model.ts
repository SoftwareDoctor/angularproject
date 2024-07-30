export class Resume {
  idResume: number;
  title: string;
  cv: string[];

  constructor(idResume: number, title: string, cv: string[]) {
    this.idResume = idResume;
    this.title = title;
    this.cv = cv;
  }
}
