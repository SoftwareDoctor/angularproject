export class Blog {
  idArticle: number;
  titleArticle: string;
  textArticle: string;
  tag: string;


  constructor(idArticle: number, titleArticle: string, textArticle: string, tag: string) {
    this.idArticle = idArticle;
    this.titleArticle = titleArticle;
    this.textArticle = textArticle;
    this.tag = tag;
  }
}


