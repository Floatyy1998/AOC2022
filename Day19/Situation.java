package Day19;

record Situation(
    Robots robots,
    RobotTypeWithCost robotBoughtToCreateThisSituation,
    Resources resources,
    Situation parent) {

  static Situation initialSituation() {
    Robots initialRobots = new Robots().addOneRobot(ResourceType.ORE);
    Resources initialResources = new Resources();
    return new Situation(initialRobots, null, initialResources, null);
  }

  @Override
  public String toString() {
    // Don't include the parent!
    return "Situation[robots=" + robots + ", resources=" + resources + "]";
  }
}
