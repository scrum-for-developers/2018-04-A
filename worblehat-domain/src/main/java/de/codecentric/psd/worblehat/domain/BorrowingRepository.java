package de.codecentric.psd.worblehat.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {

    @Query("SELECT b from Borrowing b WHERE b.borrowedBook = :book")
    public Borrowing findBorrowingForBook(@Param("book")Book book);

    @Query("SELECT b from Borrowing b WHERE b.borrowerEmailAddress = :borrowerEmailAddress")
    List<Borrowing> findBorrowingsByBorrower(@Param("borrowerEmailAddress") String borrowerEmailAddress);

    @Query("SELECT b from Borrowing b WHERE b.borrowerEmailAddress = :borrowerEmailAddress ORDER BY b.borrowDate ASC")
    List<Borrowing> findBorrowingsByBorrowerOrderedByDateASC(@Param("borrowerEmailAddress") String borrowerEmailAddress);
   
    @Query("SELECT b from Borrowing b WHERE b.borrowerEmailAddress = :borrowerEmailAddress ORDER BY b.borrowDate DESC")
    List<Borrowing> findBorrowingsByBorrowerOrderedByDateDESC(@Param("borrowerEmailAddress") String borrowerEmailAddress);
 
    @Query("SELECT b from Borrowing b ORDER BY b.borrowDate ASC")
    List<Borrowing> findBorrowingsOrderedByDateASC();
   
}
