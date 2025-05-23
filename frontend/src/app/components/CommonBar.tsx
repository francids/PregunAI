import Card from "./ui/Card";

export default function CommonBar({
  children,
  className,
}: {
  children: React.ReactNode;
  className?: string;
}) {
  return <Card className={`flex mb-6 ${className}`}>{children}</Card>;
}
