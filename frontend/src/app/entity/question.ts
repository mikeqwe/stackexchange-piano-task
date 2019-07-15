export class Question {
  title: string;
  tags: string[];
  owner: ShallowUser;
  isAnswered: boolean;
  viewCount: number;
  upVoteCount: number;
  answerCount: number;
  score: number;
  creationDate: Date;
  link: string;
}

export class ShallowUser {
  reputation: number;
  displayName: string;
}
