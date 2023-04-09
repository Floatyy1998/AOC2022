package Day19;




enum ResourceType {
  ORE,
  CLAY,
  OBSIDIAN,
  GEODE;

  @Override
  public String toString() {
    return name().toLowerCase();
  }
}